require_relative 'spec_helper'

##
# Describe behaviour created in the JRuby Exception
# Class named Bar. This class include common basic
# things you can do with Classes as in JRuby Extensions
# mechanism.
##
describe Bar do

  context "simple methods" do
    it 'shout return a string' do
      expect(subject.shout).to eq("Hello World!");
    end

    it 'say return a string' do
      expect(subject.say).to eq("Hello World!");
    end
  end

  context "arithmetic operations" do

    it "add two numbers" do
      expect(subject.add(3, 2)).to eq(5)
    end

    it "substract two numbers" do
      expect(subject.subtract(3, 2)).to eq(1)
    end

    it "divide two numbers" do
      expect(subject.divide(4, 2)).to eq(2)
    end

    it "multiply two numbers" do
      expect(subject.multiply(4, 2)).to eq(8)
    end
  end
end
