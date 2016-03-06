gem 'minitest' # don't use bundled minitest
require 'java'
require 'minitest/autorun'
require 'minitest/pride'

require_relative '../lib/basic'

Dir.chdir(File.dirname(__FILE__))

class MyClass
  include Foo
end

class FooTest < Minitest::Test
  attr_reader :foo
  
  def setup
    @foo = MyClass.new
  end
  
  def test_build_string
    assert_equal foo.build_string, 'This is a new String', 'build_string failed'
  end
  
  def test_alias
    assert_equal foo.build_string, foo.new_string, 'alias failed'
  end
  
  def test_add
    assert_equal foo.add(4, 4), 8, 'add method failed'
  end
end
