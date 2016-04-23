if CCStdout == None:
    # First pass
    cc = CodingCareers__()
    cc.report('pass1')
else:
    # Second pass
    cc = CodingCareers__()
    if len(CCStdout) > 0:
        # Skulpt should support re module if we want to use regexes to check
        # stdout
        cc.expect(CCStdout == 'Hello, world!\n')
    else:
        cc.test_fail()
    cc.report('pass2')

