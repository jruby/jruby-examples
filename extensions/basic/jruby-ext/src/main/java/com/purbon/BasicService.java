package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;

import java.io.IOException;

   /** Initial setup function. Takes a reference to the current JRuby runtime and
   * sets up our Foo module and Bar class.  Since java 8 we use lambda in place of an
   * anonymous allocater.
   * Your @JRubyMethod(s) become exposed as instance methods on the Ruby module, class 
   * through the call to defineAnnotatedMethods().
   * See {https://github.com/jruby/jruby/wiki/JRubyMethod_Signatures}
   */
public class BasicService  implements BasicLibraryService {
   
     /**
     * Basic load method of the BasicLibraryService, this method is 
     * invoked when the ruby code does the related require call.
     * @param ruby An instance of the JRuby runtime.
     * @return boolean True if everything was successful, false otherwise.
     * @throws IOException is required to match the BasicLibraryService signature
     */   
   
   @Override
    public boolean basicLoad(final Ruby ruby) throws IOException {

        RubyModule foo = ruby.defineModule("Foo");
        foo.defineAnnotatedMethods(RubyFoo.class);

        RubyClass bar = ruby.defineClass("Bar", ruby.getObject(), (Ruby ruby1, RubyClass rubyClass) -> new RubyBar(ruby1, rubyClass));
        bar.defineAnnotatedMethods(RubyBar.class);

        return true;
    }
}
