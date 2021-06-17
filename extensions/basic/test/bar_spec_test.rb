gem 'minitest' # don't use bundled minitest
require 'jruby'
require 'minitest/autorun'
require 'minitest/pride'
require_relative '../lib/basic'

# Test Bar class functionality using regular 
# Minitest::Test albeit with jruby runtime

class BarTest < Minitest::Test
  attr_reader :bar
  def setup
    @bar = Bar.new
  end
  
  def test_new
    assert bar.instance_of? Bar
  end
  
  def test_shout
    assert bar.shout == 'Hello World!'
  end

  def test_say
    assert bar.say == 'Hello World!'
  end
  
  def test_add
    assert bar.add(3, 2) == 5 
  end
  
  def test_subtract
    assert bar.subtract(3, 2) == 1 
  end
  
  def test_divide
    assert bar.divide(3, 2) == 1 
  end
  
  def test_multiply
    assert bar.multiply(4, 2) == 8
  end
end

