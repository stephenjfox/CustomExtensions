# CustomExtensions
Making my Java development experience a bit more organized and less painful, one abstraction at a time.

## Useage
Build the source into a standard (non-executeable .jar)
- I know there's a main, but this is an idea pad as well

## Cool features
- Emulation of a C#-styleInt.TryParse()
  - The implementation is fare from perfect, 
- Covers some of the bases overlooked but Google's Guava
- Though the code isn't as impressive, mind you, there are functions I haven't seen elsewhere
- Check out the Collections package. There's a lot in there that I'm proud of.
  - Especially some of the more advanced generics programming you can do.
    - Great example: com.fox.collections.CollectionExtension.castBetter()

- MathExtension takes the guess work out of using Random.
  - Will do more in the future.	 

### Where it is
As of 24/09/2015, it's useable.
- In many projects of mine, these functions have made life easy
- I find the schemes logical, or at worst the least of evils available

### Where help is neede
- Naming convension
  - I am not a rockstar at naming things
  - This is actually in the codebase:
``` 
public class ConsoleLogger {

    private static C_Logger log;
...
}
```
- Code quality improvements
  - I wrote lots of this at different stages in my development career
  - Some of the code is fairly amatuer, but I'm looking for someone to help me this endeavor

- Consistent naming. I like the "*Extension" that is seen through a lot of collections package, but using *2 (i.e. "Functions2") isn't bad.
  - And then there's the extra plurality (String functions go in "Strings", etc)
- Expert critique
  - This has been my pet project for ages
  - Experienced eyes need to chew it to bits and make me better
