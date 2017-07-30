# Anko-ExpandableTextView

[ ![Download](https://api.bintray.com/packages/arslancharyev31/android/expandable-textview/images/download.svg) ](https://bintray.com/arslancharyev31/android/expandable-textview/_latestVersion)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

An Expandable TextView for Android (Api 16+) which is entirely written in
[Kotlin](https://kotlinlang.org/) and takes advantage of [Anko](https://github.com/Kotlin/anko).
The library also handles configuration changes, so that the view remains
expanded/collapsed on configuration change. Extends from `AppCompatTextView`.

## Table of Contents

- [Demo project](#demo-project)
- [Getting started](#getting-started)
- [Usage](#usage)
  - [Useful attributes](#useful-attributes)
  - [Extensions](#extensions)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Demo Project

Take a look at the [demo project](demo)
with examples of using this library in Kotlin with [Anko DSL](https://github.com/Kotlin/anko/wiki/Anko-Layouts)
as well as in Java with traditional xml.

![Demo](https://github.com/arslancharyev31/Anko-ExpandableTextView/blob/v1.0.2/demo.gif)

## Getting Started

The library is included in jCenter, so just add this dependency to your module level `gradle.build`:

```groovy
dependencies {
    implementation 'tm.charlie.androidlib:expandable-textview:1.1.1'
}
```

## Usage

1. Define the `android:maxLines` attribute to set the number of lines for `ExpandableTextView`'s collapsed state.
2. Provide unique `id` so that library could restore its expanded/collapsed state after configuration change.

Then just use `ExpandableTextView` as you would use any other `TextView`.

#### Useful attributes

| Attribute name             | Format                                        | Description | Default |
| -------------------------|--------------------------------------------|-------------|---------|
| *android:maxLines* | integer >= 0 | **REQUIRED**: Number of lines in collapsed state | [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) |
| *android:ellipsize* | either `marquee`, `start`, `middle`, `end` or `none` | See [Android Docs](https://developer.android.com/reference/android/widget/TextView.html#attr_android:ellipsize) | `none` |
| *app:animationDuration* | integer >= 0 | Duration of expand/collapse animation in milliseconds | 350 |

#### Extensions

Additionally, library provides [extension functions](https://kotlinlang.org/docs/reference/extensions.html)
for easy DSL layout building. Like so:
```groovy
expandableTextView(text = "Lorem ipsum...") {
    maxLines = 3
}
```
[More in demo project](demo/src/main/java/tm/charlie/expandabletextview/demo/KotlinActivity.kt#L31-L46).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
 
This library is based on its Java counterpart: [Android-ExpandableTextView](https://github.com/Blogcat/Android-ExpandableTextView).