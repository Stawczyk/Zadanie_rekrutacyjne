package Task.Service;

import Task.Model.GitInformation;
import Task.Model.UserName;

import java.util.List;

public interface GitInformationService {

    List<GitInformation> getGitInformation(UserName userName);

}
