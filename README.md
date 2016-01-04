# Awesome-Screenshots (NOT PUBLISHED)
gradle plugin to transform boring screenshots to awesome ones AND allows localisation of text

![alt text](https://github.com/sdoward/Awesome-Screenshots/blob/master/art/before.png "before")  -->       ![alt text](https://github.com/sdoward/Awesome-Screenshots/blob/master/art/after.png "after")


## Usage

- Add the plugin
```groovy
apply plugin: 'com.sdoward.awesomescreenshots'
```

- Define colors and the directory in your gradle script

```groovy
screenShot {
    backgroundColor = "#4ab581"
    shadowColor = "#18824e"
    textColor = "#12613a"
    directory = "play"
}

```

- Create the directory for your screenshots

```
- [src]
  |
  + - [main]
      |
      + - [play]
          |
          + - [en-US]
          |   |
          |   + - [original]
          |   |   |
          |   |   + - screenshot1.png
          |   |   |
          |   |   + - screenshot2.png
          |   |
          |   + - [awesome]
          |   |
          |   + - strings.xml
          |
          + - [de-DE]
          |   |
          |   + - [original]
          |   |   |
          |   |   + - screenshot1.png
          |   |   |
          |   |   + - screenshot2.png
          |   |
          |   + - strings.xml
          |   |
          |   + - [awesome]
```
- Add string resources - The strings should have the same name as the original screenshot appended with `-header1` and `-header2` 

 
```
<?xml version="1.0" encoding="UTF-8"?>
<resources>
    <screenshot1-header1>See Maps</screenshot1-header1>
    <screenshot1-header2>wherever you are</screenshot1-header2>
    <screenshot2-header1>Routes for...</screenshot2-header1>
    <screenshot2-header2>bikes, cars, and PT</screenshot2-header2>
</resources>
```

- Run `./gradlew createAwesomeScreenshots` and be happy :)

License
-------

    Copyright (C) 2015 Sam Doward

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
