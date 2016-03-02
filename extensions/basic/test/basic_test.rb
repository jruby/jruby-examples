gem 'minitest' # don't use bundled minitest
require 'java'
require 'minitest/autorun'
require 'minitest/pride'

require_relative '../lib/basic'

Dir.chdir(File.dirname(__FILE__))

class MyRubyClass
  include Foo
end

class BasicTest < Minitest::Test
  def test_new
    bar = Bar.new
    assert bar.kind_of? Bar
  end
  
  def test_say
    bar = Bar.new
    assert_equal(bar.say, 'Hello World!')
  end
  
  def test_alias
    bar = Bar.new
    assert_equal(bar.say, bar.shout)
  end
  
  def test_add
    bar = Bar.new
    assert_equal(bar.add(4, 4), 8)
  end
  
  def test_module   
    assert_equal(MyRubyClass.new.build_string, Foo.build_string)
  end
end
