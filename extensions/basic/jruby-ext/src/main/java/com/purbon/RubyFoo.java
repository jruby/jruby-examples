package com.purbon;

import org.jruby.*;
import org.jruby.anno.JRubyMethod;
import org.jruby.anno.JRubyModule;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic module named RubyFoo, created for learning purposes
 * Created by purbon on 24/08/15.
 */
@JRubyModule( name = "Foo")
public class RubyFoo extends RubyObject {

    public RubyFoo(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * Extension method with two names (aliases) that return an string). This is
     * an static method.
     * @param context The ThreadContext of the execution. (required)
     * @param self A reference to self, aka like this in java but in ruby. (required)
     * @return A RubyString.
     */
    @JRubyMethod( module = true, name = { "build_string", "new_string" } )
    public static RubyString buildAnString(ThreadContext context, IRubyObject self) {
        Ruby runtime = context.runtime;
        return runtime.newString("This is a new String");
    }

    /**
     * Extension method that add two numbers. ( NOTE: keep in mind we're in ruby, so
     * parameters should be IRubyObjects, not directly numbers )
     * @param context The ThreadContext in the execution.
     * @param a A ruby object
     * @param b A ruby object
     * @return The outcome of doing a plus b.
     */
    @JRubyMethod(module = true, name = "add")
    public IRubyObject add(ThreadContext context, IRubyObject a, IRubyObject b) {
        // This is another example of method call, where we use call as if we
        // where actually in Ruby, (ex: a + b).
        return a.callMethod(context, "+", b);
    }

    /**
     * Extensions method binding with static methods, this method does not use name so it
     * takes the name from the extension method.
     * @param context The ThreadContext of the extension. (required)
     * @param self A reference to self, aka like this in java but in ruby. (required)
     * @return A RubyHash with the default options.
     */
    @JRubyMethod( module = true )
    public static IRubyObject default_options(ThreadContext context, IRubyObject self) {
        RubyHash options = new RubyHash(context.runtime);
        options.put("hostname", "example.org");
        return options;
     }
}
