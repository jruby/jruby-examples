## JRuby Extensions basic concepts

This project aims to demo small and easy concepts around jruby extensions, this concepts will be listed as

### Creating Classes and Modules

* For java method signatures, and @JRubyMethod annotations see the [wiki][]
* Loading the extensions
* ...

### Building the extension using polyglot maven

* For details on compiling the java extensions using [polyglot maven][] see this [guide][]

Or for the impatient

```bash
mvn # builds basic.jar in target folder
```

```bash
mvn javadoc:javadoc # javadoc
```

For jdk-11+ replace

```ruby
source: '${maven.compiler.source}',
target: '${maven.compiler.target}'
```

with

```ruby
release: '${maven.compiler.release}'
```
You may also wish to replace insertion of a manual Manifest, with an automatic module viz:

```ruby
plugin(:jar, '3.2.0',
  'archive' => {
    'manifestEntries' => {
      'Automatic-Module-Name' => '${my.module}'
    }
    })
```




[polyglot maven]:https://github.com/takari/polyglot-maven
[wiki]:https://github.com/jruby/jruby/wiki/Method-Signatures-and-Annotations-in-JRuby-extensions
[guide]:https://github.com/jruby/jruby/wiki/Java-extensions-for-JRuby-using-polyglot-maven
