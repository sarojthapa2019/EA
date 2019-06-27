The main difference is that,
@Autowired and @Inject works similar for 100% without any differentiation.
These two annotations using AutowiredAnnotationBeanPostProcessor to inject dependencies.
But,@Resource uses CommonAnnotationBeanPostProcessor to inject dependencies
and there is difference in the order of checking.

@Autowired and @Inject

Matches by Type
Restricts by Qualifiers
Matches by Name

@Resource
Matches by Name
Matches by Type
Restricts by Qualifiers (ignored if match is found by name)