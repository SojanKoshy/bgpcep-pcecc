Copyright (c) 2016 Huawei Technologies Co., Ltd. All rights reserved.

This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html

DIRECTORY ORGANIZATION
======================
pcep: PCEP-related artifacts

pcep/pcecc: PCEPCC related artifacts

HOW TO BUILD
============
In order to build it's required to have JDK 1.7+ and Maven 3+, to get a build going it's needed to:

1) Run "mvn clean install" in bgpcep to generate jar in your local repository
2) For running with karaf, build the distribution 

   cd integration-distribution
   mvn clean install
   
