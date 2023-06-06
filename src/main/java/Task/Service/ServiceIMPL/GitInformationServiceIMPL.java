package Task.Service.ServiceIMPL;
import Task.Model.GitInformation;
import Task.Model.UserName;
import Task.Repo.GitInformationRepository;
import Task.Service.GitInformationService;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GitInformationServiceIMPL implements GitInformationService {

    GitInformationRepository gitInformationRepository;

    public GitInformationServiceIMPL(GitInformationRepository gitInformationRepository) {
        this.gitInformationRepository = gitInformationRepository;
    }

    @Override
    public List<GitInformation> getGitInformation(UserName userName) {
        String repositoryName = "", login = "";
        int r = 0;
        String stringUserName = userName.getUserName();

        List<GitInformation> gitInformationList = new ArrayList<GitInformation>();


            String jsonRepoString = gitInformationRepository.getRepos(stringUserName);

            JSONArray jsonRepoArray = new JSONArray(jsonRepoString);

            for (int i = 0; i < jsonRepoArray.length(); i++) {
                boolean fork = jsonRepoArray.getJSONObject(i).getBoolean("fork");
                if (!fork) {
                    repositoryName = jsonRepoArray.getJSONObject(i).getString("name");
                    login = jsonRepoArray.getJSONObject(i).getJSONObject("owner").getString("login");

                    String jsonBranchesString = gitInformationRepository.getBranches(stringUserName, repositoryName);
                    JSONArray jsonBranchesArray = new JSONArray(jsonBranchesString);
                    Map<String, String> mapBranchesAndSha = new HashMap<String, String>();
                    for (; r < jsonBranchesArray.length(); r++) {

                        mapBranchesAndSha.put(jsonBranchesArray.getJSONObject(r).getString("name"), jsonBranchesArray.getJSONObject(r).getJSONObject("commit").getString("sha"));
                    }
                    r = 0;
                    GitInformation gitInformation = new GitInformation(repositoryName, login, mapBranchesAndSha);
                    gitInformationList.add(gitInformation);

                }
            }


            return gitInformationList;

    }


}
