package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyHash;
import org.jruby.RubyObject;
import org.jruby.RubyString;
import org.jruby.anno.JRubyMethod;
import org.jruby.anno.JRubyModule;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic module named Foo Created by purbon on 24/08/15.
 */
@JRubyModule(name = "Foo")
public class RubyFoo extends RubyObject {

    /**
     *
     * @param ruby
     * @param metaclass
     */
    public RubyFoo(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * Example ruby aliases that return a string. This is a kind of pointless
     * method, but is simple to understand. The equivalent in ruby: 
     * module Foo 
     *   def self.build_string
     *     return 'This is a new String' 
     *   end alias_method :build_string :new_string
     * end
     *
     * @param context The ThreadContext of the execution. (required)
     * @param self A reference to self (required)
     * @return A RubyString.
     */
    @JRubyMethod(module = true, name = {"build_string", "new_string"})
    public static RubyString buildString(ThreadContext context, IRubyObject self) {
        Ruby runtime = context.runtime;
        return runtime.newString("This is a new String");
    }

    /**
     * A ruby method that adds two numbers. In practice we would do some operation
     * in java possibly using a library method, or a method of our own creation.
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
     * Extension method binding with a static method, this method does not use
     * name so it takes the name from the extension method.
     *
     * @param context The ThreadContext of the extension. (required)
     * @param self A reference to self (required)
     * @return A RubyHash with the default options.
     */
    @JRubyMethod(module = true)
    public static IRubyObject default_options(ThreadContext context, IRubyObject self) {
        RubyHash options = new RubyHash(context.runtime);
        options.put("hostname", "example.org");
        return options;
    }
}
