import org.example.AddSidebarLinkAction;
def call(Map config = [:]){
  echo "Hello ${config.name} ${new AddSidebarLinkAction().num()} "
}
