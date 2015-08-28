package com.purbon;

import org.jruby.*;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic class created for learning purposes.
 * Created by purbon on 24/08/15.
 */

@JRubyClass(name = "Bar")
public class RubyBar extends RubyObject {

    public RubyBar(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * Extension method with two names (aliases) that return a Hello World string). This is
     * an static method.
     * This would be equivalent to the ruby:
     *    class Bar
     *       class << self
     *          def shout()
     *            return "Hello World!"
     *          end
     *          alias_method :shout, :say
     *       end
     *     end
     * @param context The ThreadContext of the execution. (required)
     * @param self A reference to self, aka like this in java but in ruby. (required)
     * @return A Hello World! RubyString.
     */
    @JRubyMethod(module = true, name = {"shout", "say"})
    public static RubyString shout(ThreadContext context, IRubyObject self) {
         // One common thing is to create ruby object, for some of them
         // the runtime has to be used, or pass as parameter.
         return context.runtime.newString("Hello World!");
    }

    /**
     * Extension method that add two numbers. ( NOTE: keep in mind we're in ruby, so
     * parameters should be IRubyObjects, not directly numbers ).
     * This would be equivalent to the ruby:
     *    class Bar
     *      def add(a,b)
     *        return a+b
     *      end
     *    end
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

    // The next methods are doing the same, but with other arithmetic operators.

    @JRubyMethod(module = true, name = "sub")
    public IRubyObject sub(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "-", b);
    }

    @JRubyMethod(module = true, name = "div")
    public IRubyObject div(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "/", b);
    }

    @JRubyMethod(module = true, name = "plus")
    public IRubyObject plus(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "*", b);
    }

}
