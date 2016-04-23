if CCStdout == None:
    # First pass
    cc = CodingCareers__()
    try:
        cc.expect(year == int(year))
    except NameError:
        cc.test_fail()
    try:
        cc.expect(month == str(month))
    except NameError:
        cc.test_fail()
    cc.report('pass1')
else:
    import re
    # Second pass
    cc = CodingCareers__()
    # re.DOTALL is unsupported, so is \n. use [\s\S] instead
    # re.IGNORECASE is horribly buggy
    match = re.search('[0-9]{4}(.|\s|\S)*(january|february|march|april|may|june|july|august|september|october|november|december)', CCStdout.lower())
    cc.expect(match is not None)
    cc.report('pass2')

