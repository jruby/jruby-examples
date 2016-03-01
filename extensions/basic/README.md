## JRuby Extensions basic concepts

This project aims to demo small and easy concepts around jruby extensions, this concepts will be listed as

* Classes and Modules
* Static methods in both elements
* Loading the extensions
* ...

### Polyglot maven build

```bash
mvn # builds basic.jar
```

```bash
mvn javadoc:javadoc # javadoc
```

[Polyglot maven][] has to be the way to go (ant was bad enough but maven is bloody diabolical in xml). Polyglot maven is really simple and well thought out (except they don't seem have completely caught up with the _new_ well like since ruby 1.9 hash) but you can use it anyway (and snake case).



[Polyglot maven]:https://github.com/takari/polyglot-maven