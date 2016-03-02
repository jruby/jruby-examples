package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;

import java.io.IOException;

/**
 * This class is used when to run the instantiation and load
 * of all the related modules and classes defined here.
 * Created by purbon on 24/08/15.
 */
public class BasicService  implements BasicLibraryService {

    @Override
    public boolean basicLoad(final Ruby ruby) throws IOException {

        RubyModule foo = ruby.defineModule("Foo");
        foo.defineAnnotatedMethods(Foo.class);

        RubyClass bar = ruby.defineClass("Bar", ruby.getObject(), new ObjectAllocator() {
             @Override
             public IRubyObject allocate(Ruby ruby, RubyClass rubyClass) {
                return new Bar(ruby, rubyClass);
            }
        });
        bar.defineAnnotatedMethods(Bar.class);

        return true;
    }
}
