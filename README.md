# CustomExtensions
Making my Java development experience a bit more organized and a LOT less painful, one abstraction at a time.

## Usage
Build the source into a standard (non-executable .jar)
- I know there's a ```main()```, but this is an idea testing pad as well
  - This ```main``` was ametuerish testing. Will be removed in next major update.

## Cool features
- Emulation of a C#-style Int.TryParse()
  - The implementation is fare from perfect, 
- Covers some of the bases overlooked but Google's Guava
- Though the code isn't as impressive, mind you, there are functions I haven't seen elsewhere
- Check out the [https://github.com/stevemasta34/CustomExtensions/tree/master/src/com/fox/collections](Collections) package. There's a lot in there that I'm proud of.
  - Especially some of the more advanced generics programming you can do.
    - Great example: CollectionExtension.castBetter()
  - SizedLinkedList and the Tuple<T1...T5> are pretty cool

- MathExtension 
  - Takes the guess work out of using Random.

### Where it is
As of 24/09/2015, it's usable and stable.
- In many projects of mine, these functions have made life easy
- I find the schemes logical, or at worst the least of evils available

### Where help is needed
- Naming convention
  - I am not a rock star at naming things
  - This is actually in the codebase:
``` 
public class ConsoleLogger {

    private static C_Logger log;
// other GOOD code
}
```
- Code quality improvements
  - I wrote lots of this at different stages in my development career
  - Some of the code is fairly amatuer, but I'm looking for someone to help me this endeavor

- More testing coverage

- Expert critique
  - This has been my pet project for ages
  - Experienced eyes need to chew it to bits and make me better

- (As of 25/01/2016) Needs more flushed out Collections-typed functionality.
  - What is there as of now, while highly effective, is minimal. This library can be more.
