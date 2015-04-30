# PassCrackGUI
*PassCrackGUI* is an open-source graphical interface toolkit written in Java. The toolkit was developed with the main goal of allowing users to easily utilize popular password cracking tools. The toolkit currently contemplates Hashcat, *John the Ripper (JTR)* and *RainbowCrack*, allowing to execute cracking commands of hash values against a generated or predefined password list. *PassCrackGUI* has a smooth environment that can help users to use the tools mentioned before, without worrying to write command line commands and arguments for those tools.

*PassCrackGUI* currently allows to perform dictionary and brute-force attacks accordingly with the capabilities of the underlying cracking tools, namely *Hashcat* and *JTR*. *RainbowCrack* uses a time-memory tradeoff algorithm to compute rainbow tables beforehand. The toolkit allows to generate a customized dictionary by means of a tool called Crunch, among other features. 

This toolkit was mainly developed for academic purposes, but it is appropriate to use by anyone who wishes to explore this field of knowledge.


# User Manual and Usage Example
The toolkit has a friendly interface and it is intuitive. The following steps illustrate a usage example to crack a given hash value:

- The toolkit allows the specification of a clear text, a single hash value or an input file with multiple hash values delimited by a newline. In case of the clear text this can be computed by either MD5, SHA1, or SHA256. If the input hash value(s) is(are) unknown, the toolkit can figure that out by verifying the length of the hash against the output of the mentioned hash functions.
- The specification of the attack can be done afterwards, allow to a select dictionary attack, a rainbow table attack (available only for *RainbowCrack*), or a mask brute-force attack. The so-called replacement tables can be further specified when a dictionary attack is selected. This allows to replace some characters that users usually switch with numbers alike (*e.g.*, "water" could become "w4t3r").
- When running, the toolkit shows the output of the underlying tools and other useful information of the cracking procedures, using most of the CPU capabilities of the computer until a result is achieved.


# Requirements and Dependencies

*PassCrackGUI* was written in Java with version 1.0.8_25. The main execution entry point is defined on the ```Interface.java``` file and runs best on an interface with a minimum resolution of 1321 x 667.
The toolkit also requires [Hashcat](http://hashcat.net/oclhashcat/), [JTR](http://www.openwall.com/john/) and [RainbowCrack](http://project-rainbowcrack.com/) to be installed and readily available on the running computer. 
