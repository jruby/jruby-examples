package com.purbon;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.RubyString;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * A basic class created for learning purposes
 * Created by purbon on 24/08/15.
 */

@JRubyClass(name = "Bar")
public class Bar extends RubyObject {

    public Bar(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    @JRubyMethod(name = {"shout", "say"})
    public IRubyObject shout_ruby(ThreadContext context) {
         return context.runtime.newString("Hello World!");
    }

    @JRubyMethod(name = "add")
    public IRubyObject add_ruby(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "+", b);
    }

    @JRubyMethod(name = "subtract")
    public IRubyObject sub_ruby(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "-", b);
    }

    @JRubyMethod(name = "divide")
    public IRubyObject div(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "/", b);
    }

    @JRubyMethod(name = "multiply")
    public IRubyObject mult(ThreadContext context, IRubyObject a, IRubyObject b) {
        return a.callMethod(context, "*", b);
    }

}
