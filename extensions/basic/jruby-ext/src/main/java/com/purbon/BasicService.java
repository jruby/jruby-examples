package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;

import java.io.IOException;

/**
 * This class is used to load all related modules in a lib (metaphor in the extensions mechanism).
 * Everything defined in the load method would be instantiated when teh ruby code does the require
 * poiting to this service. (Example require "com/purbon/basic")
 * Created by purbon on 24/08/15.
 */
public class BasicService  implements BasicLibraryService {

    /**
     * Basic load method as stated in the BasicLibraryService, this method is going to be
     * invoken when the ruby code does the related require call.
     * @param ruby An instance of the JRuby runtime.
     * @return boolean True if everything was successful, false otherwise.
     * @throws IOException
     */
    public boolean basicLoad(final Ruby ruby) throws IOException {

        /**
         * This way you can make a module defined inside the extension
         * available in the ruby world.
         **/
        RubyModule foo = ruby.defineModule("Foo");
        foo.defineAnnotatedMethods(RubyFoo.class); // necessary to actually define the methods.

        /**
         * This is the way to define a class, works similar to the module example, but
         * you need to pass also the parent object, and an allocator that will be responsible
         * to initialize the extension class (in this case RubyBar).
         **/
        RubyClass bar = ruby.defineClass("Bar", ruby.getObject(), new ObjectAllocator() {
             public IRubyObject allocate(Ruby ruby, RubyClass rubyClass) {
                return new RubyBar(ruby, rubyClass);
            }
        });
        bar.defineAnnotatedMethods(RubyBar.class); // As in the module, necessary to define the methods.

        return true;
    }
}
