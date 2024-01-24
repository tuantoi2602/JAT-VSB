package cz.vsb.jat.controllers.support;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CdiSupport {

	public Set<Bean<?>> getBeans() {
		Set<Bean<?>> beans = CDI.current().getBeanManager().getBeans(Object.class);
		return beans;
	}

	public Collection<Bean<?>> getNamedBeans() {
		return CDI.current().getBeanManager().getBeans(Object.class).stream().filter(b -> b.getName() != null)
				.collect(Collectors.toList());
	}

	public Collection<Bean<?>> getCzBeans() {
		return CDI.current().getBeanManager().getBeans(Object.class).stream()
				.filter(b -> b.getBeanClass().getCanonicalName().startsWith("cz.")).collect(Collectors.toList());
	}

}
