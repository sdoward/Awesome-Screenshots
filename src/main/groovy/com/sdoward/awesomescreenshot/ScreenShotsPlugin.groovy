package com.sdoward.awesomescreenshot

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class ScreenShotsPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getExtensions().create("screenShot", ScreenShotExtension.class)

        Map<String,Object> taskInfo = new HashMap<>()
        taskInfo.put("type", ScreenShotTask.class)
        taskInfo.put("description", "Generates awesome screenshots.")
        taskInfo.put("group", "Awesome Screenshots")
        Task myPluginTask = project.task(taskInfo, "createAwesomeScreenShots")
    }
}