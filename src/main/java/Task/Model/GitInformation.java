package Task.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Map;

public class GitInformation {

   private String repositoryName ;
   private String ownerLogin;
   private Map <String,String> branchesData ;

    public GitInformation() {
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public Map<String, String> getBranchesData() {
        return branchesData;
    }

    public void setBranchesData(Map<String, String> branchesData) {
        this.branchesData = branchesData;
    }

    public GitInformation(String repositoryName, String ownerLogin, Map<String, String> branchesData) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branchesData = branchesData;
    }

    @Override
    public String toString() {
        return "GitInformation{" +
                "repositoryName='" + repositoryName + '\'' +
                ", ownerLogin='" + ownerLogin + '\'' +
                ", branchesData=" + branchesData +
                '}';
    }
}