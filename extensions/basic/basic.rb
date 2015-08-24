require "java"
$CLASSPATH << File.join(File.dirname(__FILE__),  "jruby-ext", "target", "classes")

require "com/purbon/basic"


bar = Bar.new

puts bar.say
puts bar.shout

class MyRubyClass
  include Foo
end

puts MyRubyClass.new.build_string
puts Foo.build_string
