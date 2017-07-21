# Android-ExpandableTextView

[ ![Download](https://api.bintray.com/packages/arslancharyev31/android/Anko-ExpandableTextView/images/download.svg?version=1.0.1) ](https://bintray.com/arslancharyev31/android/Anko-ExpandableTextView/1.0.1/link)

An expandable TextView for Android (Api 16+) which is entirely written in
[Kotlin](https://kotlinlang.org/) and takes advantage of [Anko](https://github.com/Kotlin/anko).
The library also handles configuration changes, so that the view remains
expanded/collapsed on configuration change.

## Table of Contents

- [Demo project](#demo-project)
- [Getting started](#getting-started)
- [Usage](#usage)
  - [Useful attributes](#useful-attributes)
  - [Extensions](#extensions)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Demo Project

Take a look at the [demo project](https://github.com/arslancharyev31/Anko-ExpandableTextView/tree/master/demo) 
with examples of using this library in Kotlin with [Anko DSL](https://github.com/Kotlin/anko/wiki/Anko-Layouts)
as well as in Java with traditional xml.

![Demo](https://github.com/arslancharyev31/Anko-ExpandableTextView/blob/master/demo.gif)

## Getting Started

Add this maven repository in your project level `gradle.build`. Support for mavenCentral/jCenter is coming soon...

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://dl.bintray.com/arslancharyev31/android" }
    }
}
```

And add this dependency to your module level `gradle.build`:

```groovy
dependencies {
    compile 'tm.charlie:expandabletextview:1.0.1'//Use `implementation` if you are using gradle plugin 3.0+
}
```

## Usage

1. Define the `android:maxLines` attribute to set the number of lines for `ExpandableTextView`'s collapsed state.
2. Provide unique `id` to retain expanded/collapsed state.

Then just use `ExpandableTextView` as you would use any other `TextView`.

#### Useful attributes

| Attribute name             | Format                                        | Description | Default |
| -------------------------|--------------------------------------------|-------------|---------|
| *android:maxLines* | integer >= 0 | **REQUIRED**: Number of lines in collapsed state | [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) |
| *android:ellipsize* | either `marquee`, `start`, `middle`, `end` or `none` | see [Android Docs](https://developer.android.com/reference/android/widget/TextView.html#attr_android:ellipsize) | `none` |
| *app:animationDuration* | integer >= 0 | Duration of expand/collapse animation in milliseconds | 350 |

#### Extensions

Additionally, library provides [extension functions](https://kotlinlang.org/docs/reference/extensions.html)
for easy DSL layout building. Example(more in demo project):
```groovy
expandableTextView(text = "Lorem ipsum...") {
    maxLines = 3
}
```

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/arslancharyev31/Anko-ExpandableTextView/blob/master/LICENSE) file for details.

## Acknowledgments
 
This library is based on its Java counterpart: [Android-ExpandableTextView](https://github.com/Blogcat/Android-ExpandableTextView).