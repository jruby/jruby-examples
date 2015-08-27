package com.purbon;

import org.jruby.*;
import org.jruby.anno.JRubyMethod;
import org.jruby.anno.JRubyModule;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic module named RubyFoo
 * Created by purbon on 24/08/15.
 */
@JRubyModule( name = "Foo")
public class RubyFoo extends RubyObject {

    public RubyFoo(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    @JRubyMethod( module = true, name = { "build_string", "new_string" } )
    public static RubyString buildAnString(ThreadContext context, IRubyObject self) {
        Ruby runtime = context.runtime;
        return runtime.newString("This is a new String");
    }
}
