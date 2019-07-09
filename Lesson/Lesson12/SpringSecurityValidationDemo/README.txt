For register a new user, must have to have OpenEntityManagerInView setted. need to figure it out the reason

<sec:global-method-security
            secured-annotations="enabled"
            jsr250-annotations="enabled"
            pre-post-annotations="enabled"/>
MUST be in springmvc-servlet.xml file, doesn't work if put in spring-security.xml