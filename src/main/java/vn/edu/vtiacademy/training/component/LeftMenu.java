package vn.edu.vtiacademy.training.component;
import io.qameta.allure.Step;
import vn.edu.vtiacademy.training.object_repo.LeftMenuRepo;
import vn.edu.vtiacademy.training.project.exercise4.EditAccount;
import vn.edu.vtiacademy.training.project.exercise4.NewAccount;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
public class LeftMenu extends BaseComponent {
  public LeftMenu(WebUI webUI) {
    super(webUI);
  }

  @Step("Click New Customer at Left Menu")
  public NewAccount goToNewCustomer() {
    webUI.clickElement(LeftMenuRepo.LNK_NEW_ACCOUNT);
    return new NewAccount(webUI);
  }

  @Step("Click Edit Customer at Left Menu")
  public EditAccount goToEditCustomer() {
    webUI.clickElement(LeftMenuRepo.LNK_EDIT_ACCOUNT);
    return new EditAccount(webUI);
  }
}
