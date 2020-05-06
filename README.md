# okhttptest

### openjdk=8 maven=3.6

There are some empty folders in maven project.

"src/test/resources"

"src/main/resources"

They would be ignored by git.

It might cause some errors.

Please add those folders manually.
```
cd some_java_notes
mkdir src/test src/test/resources
mkdir src/main/resources
```