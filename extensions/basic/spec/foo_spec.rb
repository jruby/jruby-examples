require "spec_helper"

##
# Describe behaviour created in the JRuby extension
# Module named Foo. This class include common basic
# things you can do with modules as in JRuby Extensions
# mecanisms.
##
describe Foo do

  context "simple static methods" do
    it 'shout return a hash with a hostname' do
      expect(subject.default_options).to include( "hostname" => "example.org" )
    end

  end

end