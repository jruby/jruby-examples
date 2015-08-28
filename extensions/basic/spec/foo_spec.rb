require "spec_helper"

##
# Describe behaviour created in the JRuby extension
# module named Foo. This class include common basic
# things you can do in the JRuby extension mechanism.
##
describe Foo do

  context "static methods" do
    it 'shout return a hash with a hostname' do
      expect(subject.default_options).to include( "hostname" => "example.org" )
    end
  end

  context "instance methods" do

    subject(:foo) { FooClass.new }

    it "should add two numbers" do
      expect(foo.add(2,3)).to eq(5)
    end

  end

end