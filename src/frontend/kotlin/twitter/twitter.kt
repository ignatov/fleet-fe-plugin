package twitter

import com.jetbrains.rhizomedb.Entrypoint
import fleet.frontend.actions.ActionsEP
import fleet.frontend.actions.windowManager
import fleet.kernel.ChangeScope
import fleet.kernel.register
import noria.model.Action
import noria.model.ActionPresentation
import noria.model.Propagate
import noria.model.Trigger
import noria.windowManagement.extensions.openUrl

@Entrypoint
fun ChangeScope.registerTwitterAction() {
    println("Register Open Twitter action")
    register {
        ActionsEP.register {
            Action(
                defaultPresentation = ActionPresentation("Open Twitter"),
                perform = { ac ->
                    ac.windowManager.openUrl("https://twitter.com/jetbrains_fleet/")
                    Propagate.STOP
                },
                triggers = setOf(trigger)
            )
        }
    }
}

val trigger = Trigger("open-twitter")