require "spec_helper"

##
# Describe behaviour created in the JRuby extension
# class named Bar. This class include common basic
# things you can do in the JRuby extension mechanism.
##
describe Bar do

  context "simple class methods" do
    it 'shout return an string' do
      expect(Bar.shout).to eq("Hello World!");
    end

    it 'say return an string' do
      expect(Bar.say).to eq("Hello World!");
    end
  end

  context "simple instance methods (aritmetic ops)" do

    subject(:bar) { Bar.new }

    it "add two numbers" do
      expect(bar.add(3, 2)).to eq(5)
    end

    it "substract two numbers" do
      expect(bar.sub(3, 2)).to eq(1)
    end

    it "divide two numbers" do
      expect(bar.div(4, 2)).to eq(2)
    end

    it "multiply two numbers" do
      expect(bar.plus(4, 2)).to eq(8)
    end

  end

end