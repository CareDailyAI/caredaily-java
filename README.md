# peoplepower-java

### Versioning

* [People Power Java](https://github.com/peoplepower/peoplepower-java) v0.2

## Table of contents

* [What's included](#whats-included)
* [Peoplepower Java](#peoplepower-java)
* [Bugs and feature requests](#bugs-and-feature-requests)
* [Versioning](#versioning)
* [Creators](#creators)
* [Copyright and license](#copyright-and-license)


## What's included

Within the download you'll find the following directories and files. You'll see something like this:

```
peoplepower-java/
│
├── README.md
├── build
│   ├── generated
│   │   ├── ap_generated_sources
│   │   ├── res
│   │   └── source
│   ├── intermediates
│   │   ├── aapt_friendly_merged_manifests
│   │   ├── aar_metadata
│   │   ├── annotation_processor_list
│   │   ├── compile_library_classes_jar
│   │   ├── compile_r_class_jar
│   │   ├── compile_symbol_list
│   │   ├── compiled_local_resources
│   │   ├── data_binding_layout_info_type_package
│   │   ├── incremental
│   │   ├── javac
│   │   ├── library_assets
│   │   ├── library_java_res
│   │   ├── library_jni
│   │   ├── library_manifest
│   │   ├── local_only_symbol_list
│   │   ├── manifest_merge_blame_file
│   │   ├── merged_jni_libs
│   │   ├── merged_shaders
│   │   ├── navigation_json
│   │   ├── packaged_manifests
│   │   ├── packaged_res
│   │   ├── public_res
│   │   ├── runtime_library_classes_jar
│   │   ├── symbol_list_with_package_name
│   │   └── transforms
│   ├── outputs
│   │   └── logs
│   └── tmp
│       └── compileDebugJavaWithJavac
├── build.gradle
├── proguard-rules.pro
└── src
    └── main
        ├── AndroidManifest.xml
        ├── java
        └── res
```

## Peoplepower Java

The People Power Java framework includes APIs, models/classes, and utilities for a frontend application.

Use it to:

* Incorporate People Power Models and APIs.  
* Define Module Configurations and Cloud URL.

For a complete definition of People Power's models and APIs, please refer to [IOT Apps](https://iotapps.docs.apiary.io/) on Apiary.

### Module Configurations
The peoplepower-java (virtuoso) can be used as a module in the android project and following steps are required to configure it.

In the android project.
1. Add ':peoplepower-java' in the settings.gradle like this

    include ':app', ':peoplepower-java'
    
2. Add :peoplepower-java' dependency in the app level of the build.gradle like this

    dependencies {
        
        ...
        implementation project(':peoplepower-java')
        ...
    
    }

### Cloud URL
The Cloud URL can be changed by modification of the getServerUrl method in the PPEnsembleTask.java to use Cloud APIs.

## Bugs and feature requests

For bugs and feature requests, submit an issue on GitHub [here](https://github.com/peoplepower/peoplepower-java/issues)

## Versioning

For transparency into our release cycle and in striving to maintain backward compatibility, Peoplepwer-Java is maintained under [the Semantic Versioning guidelines](http://semver.org/).

See [the Releases section of the GitHub project](https://github.com/peoplepower/peoplepower-java/releases) for changelogs for each release version.

## Creators

**James Cho**
* <https://github.com/hyunwoongcho>

## Copyright and license

Code and documentation Copyright 2021 People Power Co. [License](https://github.com/peoplepower/peoplepower-java/blob/master/LICENSE).
