package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic class, which would not make much sense in practice, but is simple enough to understand
 * In practice you would likely to call to some java classes to achieve the desired functionality
 * This would involve casting arguments to java doing some operations and returning a ruby object
 */

@JRubyClass(name = "Bar")
public class RubyBar extends RubyObject {

    /**
     * Java constructor
     * @param ruby
     * @param metaclass
     */
    public RubyBar(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }
    
    /**
     * Example of an alias method annotation
     * @param context The ThreadContext of the execution. (required)
     * @return A Hello World! RubyString.
     */

    @JRubyMethod(name = {"shout", "say"})
    public IRubyObject shout_ruby(ThreadContext context) {
         return context.runtime.newString("Hello World!");
    }

    /**
     * Adds two numbers (in practice you would implement some method in java, 
     * probably using an external library)
     * @param context
     * @param a
     * @param b
     * @return
     */
    @JRubyMethod(name = "add")
    public IRubyObject add_ruby(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "+", b);
    }

    /**
     * Subtract two numbers (in practice you would implement some method in java, 
     * probably using an external library)
     * @param context
     * @param a
     * @param b
     * @return
     */
    @JRubyMethod(name = "subtract")
    public IRubyObject sub_ruby(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "-", b);
    }

    /**
     * Divide two numbers (in practice you would implement some method in java, 
     * probably using an external library)
     * @param context
     * @param a
     * @param b
     * @return
     */
    @JRubyMethod(name = "divide")
    public IRubyObject div(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "/", b);
    }

    /**
     * Multiplies two numbers (in practice you would implement some method in java, 
     * probably using an external library)
     * @param context
     * @param a
     * @param b
     * @return
     */
    @JRubyMethod(name = "multiply")
    public IRubyObject mult(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "*", b);
    }
}
