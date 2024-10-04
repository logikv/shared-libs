import org.example.AddSidebarLinkAction;

def cl = new AddSidebarLinkAction()

def call(Map config = [:]){
  echo "Hello ${config.name} ${cl.num} "
}
