package com.purbon;

import org.jruby.Ruby;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.anno.JRubyModule;
import org.jruby.runtime.ThreadContext;


/**
 * A basic example module, purely for demonstration purposes.
 * See {https://github.com/jruby/jruby/wiki/JRubyMethod_Signatures}
 */
@JRubyModule(name = "Foo")
public class RubyFoo {

    /**
     * Example ruby aliases that return a string. This is a kind of pointless
     * method, but is simple to understand. The equivalent in ruby: 
     * module Foo 
     *   def build_string
     *     return 'This is a new String' 
     *   end alias_method :build_string :new_string
     * end
     *
     * @param context ThreadContext
     * @param recv the receiver
     * @return A RubyString.
     */
    @JRubyMethod(name = {"build_string", "new_string"}, module = true)
    public static IRubyObject buildString(ThreadContext context, IRubyObject recv) {
        Ruby runtime = context.getRuntime();
        return runtime.newString("This is a new String");
    }
    
    /**
     * This is a kind of pointless module class method, but is simple to understand. 
     * meta = true is waht makes this module class method
     * The equivalent in ruby: 
     * module Foo 
     *   def self.bself_string
     *     return 'This is String is from Foo.self' 
     *   end
     * end
     *
     * @param context ThreadContext
     * @param recv the receiver
     * @return A RubyString.
     */
    
    @JRubyMethod(name = "self_string", module = true, meta = true)
    public static IRubyObject buildSelfString(ThreadContext context, IRubyObject recv) {
        Ruby runtime = context.getRuntime();
        return runtime.newString("This is String is from Foo.self");
    }


    /**
     * A ruby method that adds two numbers. In practice we would do some more 
     * complex operation in java possibly using a library method, or a pure java
     * method of our own creation (possible private).
     * @param context ThreadContext
     * @param recv the receiver
     * @param args array of input arguments
     * @return The outcome of doing a plus b.
     */
    @JRubyMethod(name = "add", module = true, rest = true)
    public static IRubyObject add(ThreadContext context, IRubyObject recv, IRubyObject[] args) {
        Ruby runtime = context.getRuntime();
        // Arity.checkArgumentCount(runtime, args, Arity.OPTIONAL.getValue(), 2);
        int a = (int) args[0].toJava(Integer.class);
        int b = (int) args[1].toJava(Integer.class);
        int result = a + b;
        return runtime.newFixnum(result);
    }
}
