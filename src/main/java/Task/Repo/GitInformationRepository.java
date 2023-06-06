package Task.Repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "feignDemo", url = "https://api.github.com")

public interface GitInformationRepository {

    @GetMapping("/users/{gitUserName}/repos")
    public String getRepos(@PathVariable ("gitUserName") String gitUserName);

    @GetMapping("/repos/{gitUserName}/{reposName}/branches")
    public String getBranches(@PathVariable ("gitUserName") String gitUserName,
                              @PathVariable  ("reposName") String reposName);

}
