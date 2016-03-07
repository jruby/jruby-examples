# encoding: utf-8
# frozen_string_literal: true
require 'java' # we must use jruby runtime

# load the jar from the local directory
require_relative 'jruby-ext.jar' 
# load our ruby Bar class and Foo module into ruby runtime
# using java as follows
com.purbon.BasicService.new.basicLoad(JRuby.runtime)

# You may wish to use the camel-case form because it stands out
# that you are using 'java' to load your classes / modules
# Java::ComPurbon::BasicService.new.basicLoad(JRuby.runtime)
#
