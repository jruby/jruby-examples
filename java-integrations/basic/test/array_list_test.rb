gem 'minitest' # don't use bundled minitest
require 'java'
require 'minitest/autorun'
require 'minitest/pride'

java_import java.util.ArrayList
class ArrayList
  java_alias :simple_add, :add, [Java::int, java.lang.Object]
end

class ArrayListTest < Minitest::Test
  attr_reader :list

  def setup
    @list = ArrayList.new
  end

  def test_instance
    assert_instance_of ArrayList, list, 'create Array list failed'
  end

  def test_respond_to
    assert_respond_to list, :simple_add, 'java_alias failed'
  end

  def test_add
    list.add(0, 'SomeObject')
    assert_equal list[0], 'SomeObject', 'Failed to add SomeObject to list'
  end
end
