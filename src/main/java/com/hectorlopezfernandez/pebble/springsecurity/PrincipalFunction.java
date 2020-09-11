package com.hectorlopezfernandez.pebble.springsecurity;

import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrincipalFunction implements Function {

    public PrincipalFunction() {
        // non-instantiable
    }

    @Override
    public List<String> getArgumentNames() {
        return Collections.emptyList();
    }

    @Override
    public Object execute(Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
    	if (SecurityContextHolder.getContext() == null
    			|| SecurityContextHolder.getContext().getAuthentication() == null) {
    		return null;
    	}

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
