## JRuby Java integration basic concepts

This project aims to demo small and easy concepts around jruby integrations, this concepts will be listed as

### Reopening standard java classes

There is no substitute for working through practical examples to learn the basic concepts, here we demonstrate using java `ArrayList` in JRuby, and prove that it works using Minitest. But if you are happy with `irb` or `pry` you can try out the code snippets in those environments. Unless using one of the ruby-managers, use either:-
```bash
jirb
```
or
```bash
jruby -S jirb
jruby -S pry
```
to fire up `irb`. Note for `pry` you can easily create your own `jpry` see below
```
# in your ~/.bashrc file or equivalent
alias jpry="jruby -e \"require 'pry'; binding.pry\""
```

Here is the code where we monkey patch java `ArrayList` to respond to `simple_add` using `java_alias`.

* we use java_import to add ArrayList to our namespace (_we could have used `Java::JavaUtil::ArrayList` to access the `ArrayList` via fully qualified name_)
* note we need to provide a java signature for the aliased method
```ruby
require 'java'

java_import java.util.ArrayList
class ArrayList
  java_alias :simple_add, :add, [Java::int, java.lang.Object]
end
list = ArrayList.new
list.simple_add 0, 'foo'
```
see test/array_list_test.rb for test/demo

### Casting ruby objects to match expected java method parameters
