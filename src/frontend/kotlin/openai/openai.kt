package openai

import com.aallam.openai.api.completion.CompletionRequest
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.jetbrains.rhizomedb.Entrypoint
import fleet.frontend.actions.ActionsEP
import fleet.kernel.ChangeScope
import fleet.kernel.register
import fleet.kernel.saga
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import noria.model.Action
import noria.model.ActionPresentation
import noria.model.Propagate
import noria.model.Trigger

@Entrypoint
fun ChangeScope.registerOpenAI() {
    register {
        ActionsEP.register {
            Action(
                defaultPresentation = ActionPresentation("Ask Open AI"),
                perform = { ac ->

                    val openAI = OpenAI("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")
                    runBlocking {
                        println("> Getting available engines...")
                        openAI.models().forEach(::println)

                        println("\n> Getting ada engine...")

                        val ada = openAI.model(modelId = ModelId("text-ada-001"))
                        println(ada)

                        println("\n>️ Creating completion...")
                        val completionRequest = CompletionRequest(
                            model = ada.id,
                            prompt = "Somebody once told me the world is gonna roll me"
                        )
                        openAI.completion(completionRequest).choices.forEach(::println)

                        println("\n>️ Creating completion stream...")
                        openAI.completions(completionRequest)
                            .onEach { print(it.choices[0].text) }
                            .onCompletion { println() }
                            .launchIn(this)
                            .join()

                        println("\n> Read files...")
                        val files = openAI.files()
                        println(files)
                    }
                    Propagate.STOP
                },
                triggers = setOf(trigger)
            )
        }
    }
}

val trigger = Trigger("open-openai")