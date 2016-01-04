package com.sdoward.awesomescreenshot

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.awt.Color

class ScreenShotTask extends DefaultTask {

    String currentDirectory;

    @TaskAction
    public void createScreenShots() {
        ScreenShotExtension screenShotExtension = getProject().getExtensions().findByName("screenShot")
        File file = new File(project.name + "/src/main/${screenShotExtension.directory}/")
        file.listFiles().each {
            currentDirectory = project.name + "/src/main/${screenShotExtension.directory}/${it.name}/"
            new File(currentDirectory + 'original').listFiles().each {
                String fileName = it.name.replace(".png", "")
                ScreenShot screenShot = new ScreenShot(getHeaders(fileName + '-header1'),
                        getHeaders(fileName + '-header2'),
                        Color.decode(screenShotExtension.getBackgroundColor()),
                        Color.decode(screenShotExtension.getShadowColor()),
                        Color.decode(screenShotExtension.getTextColor()),
                        currentDirectory + 'original/' + fileName + '.png',
                        currentDirectory + 'awesome/' + fileName + '.png')
                new ScreenShotCreator().createScreenShot(screenShot)
            }
        }
    }

    def getHeaders(String name) {
        def resources = new XmlSlurper().parse(currentDirectory + 'strings.xml')
        resources."$name".toString()
    }

}