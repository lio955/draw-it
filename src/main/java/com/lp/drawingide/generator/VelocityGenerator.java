package com.lp.drawingide.generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

@Slf4j
public abstract class VelocityGenerator {

    private String outputPath;
    private String templateName;
    private String reportName;

    private static VelocityEngine velocityEngine = null;


    protected void init(final String outputPath, final String templateName, final String reportName) {

        if (VelocityGenerator.velocityEngine == null) {
            VelocityGenerator.velocityEngine = new VelocityEngine();
            VelocityGenerator.velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            VelocityGenerator.velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            VelocityGenerator.velocityEngine.init();
        }

        this.outputPath = outputPath;
        this.templateName = templateName;
        this.reportName = reportName;

    }


    protected abstract VelocityContext buildContext();

    public void generate() {
        if (VelocityGenerator.velocityEngine == null) {
            throw new RuntimeException("VelocityGenerator.init() has been called for report " + reportName);
        }
        final Template template = VelocityGenerator.velocityEngine.getTemplate("templates/" + templateName + ".vm");
        final StringWriter sw = new StringWriter();
        template.merge(buildContext(), sw);

        final File directory = new File(outputPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (final FileWriter fileWriter = new FileWriter(outputPath + File.separator + reportName)) {
            fileWriter.write(sw.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
