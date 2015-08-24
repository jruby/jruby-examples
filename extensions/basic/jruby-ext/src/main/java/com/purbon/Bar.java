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
 * A basic class created for learning purpouses
 * Created by purbon on 24/08/15.
 */

@JRubyClass(name = "Bar")
public class Bar extends RubyObject {

    public Bar(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    @JRubyMethod(module = true, name = {"shout", "say"})
    public static RubyString shout(ThreadContext context, IRubyObject self) {
         return context.runtime.newString("Hello World!");
    }

}
