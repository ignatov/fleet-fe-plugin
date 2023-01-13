module twitter {
    requires fleet.frontend;
    requires fleet.noria.ui;
    requires org.twitter4j;

    requires openai.client.jvm;
    requires openai.core.jvm;
    requires kotlinx.coroutines.core.jvm;

    exports twitter;
}