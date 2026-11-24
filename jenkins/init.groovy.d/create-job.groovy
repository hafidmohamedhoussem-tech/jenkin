import jenkins.model.Jenkins
import hudson.security.AuthorizationStrategy
import hudson.security.SecurityRealm
import hudson.plugins.git.GitSCM
import hudson.plugins.git.BranchSpec
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition

Jenkins j = Jenkins.get()
j.setSecurityRealm(SecurityRealm.NO_AUTHENTICATION)
j.setAuthorizationStrategy(new AuthorizationStrategy.Unsecured())

def scm = new GitSCM("https://github.com/hafidmohamedhoussem-tech/jenkin.git")
scm.branches = [new BranchSpec("*/main")]
def definition = new CpsScmFlowDefinition(scm, "Jenkinsfile")
def job = j.getItem("jenkins-flask-lab") ?: j.createProject(WorkflowJob, "jenkins-flask-lab")
job.setDefinition(definition)
job.save()
j.save()
println("Created jenkins-flask-lab from the GitHub main branch")
