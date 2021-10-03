package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 */
@Mojo(name = "touch", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class MyMojo extends AbstractMojo {
    /**
     * Location of the file.
     */

    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;
    @Parameter(defaultValue = "${project.build.finalName}", property = "packageName", required = true)
    private String pkgName;
    @Parameter(defaultValue = "${project.packaging}", property = "packageName", required = true)
    private String pkgExt;
    //GAV
    @Parameter(defaultValue = "${project.groupId}", property = "groupId", required = true)
    String groupId;
    @Parameter(defaultValue = "${project.artifactId}", property = "artifactId", required = true)
    String artifactId;
    @Parameter(defaultValue = "${project.version}", property = "version", required = true)
    String version;
    //Email, where to send the report
    @Parameter(property = "emailTo")
    private String emailTo;
    //От кого это письмо
    @Parameter(defaultValue = "imir2020@yandex.ru", property = "emailFrom", required = true)
    private String emailFrom;
    //theme of mail
    @Parameter(defaultValue = "Project${project.artifactId} compiled", property = "subject", required = true)
private String subject;
    //имя для авторизации на исходящем почтовом сервере


    public void execute() throws MojoExecutionException {
        File f = outputDirectory;

        if (!f.exists()) {
            f.mkdirs();
        }

        File touch = new File(f, "touch.txt");

        FileWriter w = null;
        try {
            w = new FileWriter(touch);

            w.write("touch.txt");
        } catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}
