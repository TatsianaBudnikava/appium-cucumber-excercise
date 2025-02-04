## Prerequisites 
    xcode
    iOS or Android Simulators installed
    Appium Server

### Run the APPIUM Server
    appium --base-path /wd/hub --port 4723 --allow-insecure chromedriver_autodownload --relaxed-security

### Replace absolute path in Driver Manager with your computer's. (Will refactor to use relative path in the future)
    caps.setCapability("app", "/Users/apple/AquaProjects/Test_Project1/src/test/resources/app.app");